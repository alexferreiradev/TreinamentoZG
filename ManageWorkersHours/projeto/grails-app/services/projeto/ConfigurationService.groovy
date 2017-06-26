package projeto

import grails.transaction.Transactional

@Transactional
class ConfigurationService {
    private Configuration currentConfig

    Configuration getCurrentConfig() {
        synchronized (currentConfig){
            if (currentConfig == null){
                currentConfig = Configuration.findAll().unique()
            }
        }

        return currentConfig
    }
}
