package com.dbs.directoryservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "file.service")
public class FileServiceProperties {

	/**
	 * Maximum depth to be visited by File.walkFileTree. Default value is
	 * {@code Integer.MAX_VALUE}
	 */
	private int maxDepth = Integer.MAX_VALUE;

	public int getMaxDepth() {
		return maxDepth;
	}

	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}

}
