package com.gomeo2o;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.gomeo2o.utils.MysqlSeqUtil;


public class TestMysqlSeqUtil {
	public static void main(String[] args) throws IOException {
		ExecutorService service = Executors.newFixedThreadPool(60);
		for (int i = 0; i < 20; i++) {
			service.submit(new Runnable() {

				@Override
				public void run() {
					long start = System.currentTimeMillis();
					long seqence = MysqlSeqUtil.getInstance().get("score_detail");
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
