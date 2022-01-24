package com.albo.comic.sync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SyncComicTask {
	
	private SyncComicData syncComicData;
	
	@Autowired
	SyncComicTask(SyncComicData syncComicData)  {
		this.syncComicData = syncComicData;
	}
	
	@Scheduled(cron = "0 15 0 * * *")
	public void syncComicTask() {
		syncComicData.syncData();
	}
}
