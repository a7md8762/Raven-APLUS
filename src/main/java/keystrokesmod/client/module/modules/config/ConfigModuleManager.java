package keystrokesmod.client.module.modules.config;

import keystrokesmod.client.config.Config;
import keystrokesmod.client.main.Raven;
import keystrokesmod.client.module.Module.ModuleCategory;

import java.util.ArrayList;
import java.util.List;

public class ConfigModuleManager {

    private final List<ConfigModule> modules = new ArrayList<ConfigModule>();

    public ConfigModuleManager() {

    }

    public void updater(ArrayList<Config> cfgs) {
        try {
            for (Config cfg : cfgs) {
                if (!hasModule(cfg.getName())) {
                    ConfigModule m = new ConfigModule(cfg.getName());
                    modules.add(m);
                    if (Raven.configManager.getConfig() == cfg) {
                        m.setToggled(true);
                    }
                }
            }
        } catch (NullPointerException omgwoawsocoolandedgy) {
            omgwoawsocoolandedgy.printStackTrace();
        }
        Raven.clickGui.getCategoryComponent(ModuleCategory.config).updateModules();
        Raven.clickGui.getCategoryComponent(ModuleCategory.config).r3nd3r();
    }

    public List<ConfigModule> getConfigModules() {
        return modules;
    }

    public boolean hasModule(String name) {
        return modules.stream().map(ConfigModule::getName).filter(name::equals).findFirst().isPresent();
    }

    public boolean hasConfig(ArrayList<Config> cfgs, String name) {
        return modules.stream().map(ConfigModule::getName).filter(name::equals).findFirst().isPresent();
    }
}
