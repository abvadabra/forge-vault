# forge-vault [ ![Download](https://api.bintray.com/packages/fredenergy/maven/forge-vault/images/download.svg) ](https://bintray.com/fredenergy/maven/forge-vault/_latestVersion)
Simple bridge allows Minecraft Forge Mods to access the Vault API plugin by MilkBowl


## Available version

Currently only two versions supported - 1.9 (`1.9` branch) and 1.7.10 (`master` branch)


## Gettings started

We are using bintray to publish releases so you will need add the following at the top of your build script

```
repositories {
    maven {
        url  "http://dl.bintray.com/fredenergy/maven" 
    }
}
```

And one more into dependencies

For 1.9 version

`compile 'ru.redenergy:forge-vault:1.0.0-1.9'`

For 1.7.10 version

`compile 'ru.redenergy:forge-vault:1.0.0-1.7.10'`
