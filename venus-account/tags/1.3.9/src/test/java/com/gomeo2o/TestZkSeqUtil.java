package com.gomeo2o;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.gomeo2o.utils.ZKSeqUtil;
public class TestZkSeqUtil {
	public static void main(String[] args) throws IOException {
		ExecutorService service = Executors.newFixedThreadPool(60);
		for (int i = 0; i < 10; i++) {
			service.execute(new Runnable() {

				@Override
				public void run() {
					long start = System.currentTimeMillis();
//					long seqence = ZKSeqUtil.getInstance().get("test");
					String seqence = ZKSeqUtil.getInstance().getSeqByFixedLength("test", 5);
					start = System.currentTimeMillis() - start;
					System.out.println("===================>value is : " + seqence + "  ts : " + start);
					try {
						// Thread.sleep(50);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		service.shutdown();
		System.in.read();
	}
}
