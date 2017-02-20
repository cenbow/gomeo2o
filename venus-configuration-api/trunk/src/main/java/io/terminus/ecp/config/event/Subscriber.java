package io.terminus.ecp.config.event;
import io.terminus.zookeeper.ZKClientFactory;
import io.terminus.zookeeper.pubsub.Paths;
import io.terminus.zookeeper.pubsub.SubscribeCallback;
import lombok.extern.slf4j.Slf4j;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.ACLBackgroundPathAndBytesable;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;

@Slf4j
public class Subscriber {
	private final CuratorFramework client;
	private final Paths paths;
	
	public Subscriber(ZKClientFactory zkClientFactory, String topic) throws Exception {
		this(zkClientFactory, "/pubsub", topic);
	}

	public Subscriber(ZKClientFactory zkClientFactory, String basePath,
			String topic) throws Exception {
		client = zkClientFactory.getClient();
		paths = new Paths(basePath, topic);

		if (client.checkExists().forPath(paths.getClientBase()) == null)
			client.create().creatingParentsIfNeeded()
					.forPath(paths.getClientBase());

		if (client.checkExists().forPath(paths.getTopicBase()) == null)
			client.create().creatingParentsIfNeeded()
					.forPath(paths.getTopicBase());

		if (client.checkExists().forPath(paths.getSubscriberBase()) == null)
			client.create().creatingParentsIfNeeded()
					.forPath(paths.getSubscriberBase());

		if (client.checkExists().forPath(paths.getTopicPathOfLocalHost()) == null)
			client.create().forPath(paths.getTopicPathOfLocalHost());
		
		createEphemeralNode();
	}
	
	public void subscribe(final SubscribeCallback callback) throws Exception {
		
		// 监听数据变化
		CuratorWatcher getDataWatcher = new CuratorWatcher() {			
			@Override
	        public void process(WatchedEvent event) throws Exception {	
				byte[] data = client.getData().usingWatcher(this).forPath(paths.getTopicPathOfLocalHost());
                callback.fire(data);
	        }
		};
		client.getData().usingWatcher(getDataWatcher).forPath(paths.getTopicPathOfLocalHost());
		
		// 监听节点变化
		CuratorWatcher nodeExistsWatcher = new CuratorWatcher() {		
			@Override
			public void process(WatchedEvent event) throws Exception {
				createEphemeralNode();	
				client.checkExists().usingWatcher(this).forPath(paths.getClientPathOfLocalhost());
			}
		};
		client.checkExists().usingWatcher(nodeExistsWatcher).forPath(paths.getClientPathOfLocalhost());
		addStateListener(getDataWatcher, nodeExistsWatcher);
	}

	/**
	 * @Description 创建临时节点 
	 * @author wanggang-ds6
	 * @date 2016年1月28日 下午3:29:57
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	private void createEphemeralNode() throws Exception {
		if (client.checkExists().forPath(paths.getClientPathOfLocalhost()) == null) {
			log.info("add ephemeral node {}", paths.getClientPathOfLocalhost());
			((ACLBackgroundPathAndBytesable) client.create().withMode(
					CreateMode.EPHEMERAL)).forPath(paths
					.getClientPathOfLocalhost());
		}
			
		if (client.checkExists().forPath(paths.getSubscriberPathOfLocalhost()) == null) {
			log.info("add ephemeral node {}", paths.getSubscriberPathOfLocalhost());
			((ACLBackgroundPathAndBytesable) client.create().withMode(
					CreateMode.EPHEMERAL)).forPath(paths
					.getSubscriberPathOfLocalhost());
		}			
	}
	
	/**
	 * @Description 添加状态监听 
	 * @author wanggang-ds6
	 * @date 2016年1月28日 下午3:35:50
	 * @param callbackWatcher
	 */
	private void addStateListener(final CuratorWatcher getDataWatcher, final CuratorWatcher nodeExistsWatcher) {
		log.info("add listener");
		client.getConnectionStateListenable().addListener(new ConnectionStateListener() {			
			@Override
			public void stateChanged(CuratorFramework client, ConnectionState newState) {
				/**
				 * 因网络异常，可能会导致zookeeper会话超时或失效，此时临时节点将消失，因此增加状态
				 * 监听，在新的会话里，重新产生临时节点，并注册观察者
				 */
				log.info("connection state:{}", newState);
				if(newState == ConnectionState.LOST){  
					log.info("zookeeper reconnected");
		            while(true){
		            	// 当重新连接后，每秒进行一次创建，指到成功
		            	try {
							Thread.sleep(1000);
						} catch (InterruptedException ie) {
							log.error("interrupted", ie);
							break;
						}
		                try {  
		                    if(client.getZookeeperClient().blockUntilConnectedOrTimedOut()){  
		                    	createEphemeralNode();
		                    	client.getData().usingWatcher(getDataWatcher).forPath(paths.getTopicPathOfLocalHost());
		                    	client.checkExists().usingWatcher(nodeExistsWatcher).forPath(paths.getClientPathOfLocalhost());
		                    	log.info("create ephemeral node and add watcher successfully");
		                    	break;  
		                    }  
		                } catch (InterruptedException ie) {  
		                	log.error("interrupted", ie);
		                    break;  
		                } catch (Exception e){  
		                    log.error("create ephemeral node and add watcher fails", e);
		                }  
		            }  
		        } 
			}
		}); 
	}

}
