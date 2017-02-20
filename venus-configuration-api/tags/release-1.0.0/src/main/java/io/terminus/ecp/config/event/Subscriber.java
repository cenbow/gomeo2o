package io.terminus.ecp.config.event;
import io.terminus.zookeeper.ZKClientFactory;
import io.terminus.zookeeper.pubsub.Paths;
import io.terminus.zookeeper.pubsub.SubscribeCallback;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.ACLBackgroundPathAndBytesable;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
public class Subscriber {
	private final CuratorFramework client;
	private final Paths paths;
	
	public Subscriber(ZKClientFactory zkClientFactory, String topic) throws Exception {
		this(zkClientFactory, "/pubsub", topic);
	}

	@SuppressWarnings("rawtypes")
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

		if (client.checkExists().forPath(paths.getClientPathOfLocalhost()) == null)
			((ACLBackgroundPathAndBytesable) client.create().withMode(
					CreateMode.EPHEMERAL)).forPath(paths
					.getClientPathOfLocalhost());

		if (client.checkExists().forPath(paths.getSubscriberPathOfLocalhost()) == null)

			((ACLBackgroundPathAndBytesable) client.create().withMode(
					CreateMode.EPHEMERAL)).forPath(paths
					.getSubscriberPathOfLocalhost());

		if (client.checkExists().forPath(paths.getTopicPathOfLocalHost()) == null)
			client.create().forPath(paths.getTopicPathOfLocalHost());
	}

	public void subscribe(final SubscribeCallback callback) throws Exception {
		CuratorWatcher callbackWatcher = new CuratorWatcher() {
			
			@Override
	        public void process(WatchedEvent event) throws Exception {
				
				/**
				 * 网络断开，导致会话过期后，临时节点将消失，因此增加重新生成临时节点逻辑
				 */
				if (client.checkExists().forPath(paths.getClientPathOfLocalhost()) == null)
					client.create().withMode(CreateMode.EPHEMERAL).forPath(paths
							.getClientPathOfLocalhost());

				if (client.checkExists().forPath(paths.getSubscriberPathOfLocalhost()) == null)
					client.create().withMode(CreateMode.EPHEMERAL).forPath(paths
							.getSubscriberPathOfLocalhost());
		
				byte data[] = (byte[])client.getData().usingWatcher(this).forPath(paths.getTopicPathOfLocalHost());
	            callback.fire(data);
	        }
		};
		client.getData().usingWatcher(callbackWatcher).forPath(paths.getTopicPathOfLocalHost());
	}

}
