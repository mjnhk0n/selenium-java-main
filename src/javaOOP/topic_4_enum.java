package javaOOP;

public class topic_4_enum {
	// Enum = static final
	// List of constant variable
	// vd: browser name, server name, environment name,...
	public enum EnvList {
		DEV, STAGING, PROD;
	}

	protected String getEnvValue(String serverName) {
		String envUrl = null;
		EnvList env = EnvList.valueOf(serverName.toUpperCase());
		if (env == EnvList.DEV) {
			envUrl = "https://dev.abc.com";
		} else if (env == EnvList.STAGING) {
			envUrl = "https://staging.abc.com";
		} else if (env == EnvList.PROD) {
			envUrl = "https://abc.com";
		}
		return envUrl;
	}
}
