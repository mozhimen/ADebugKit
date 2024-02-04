# ADebugKit
Android调试库 -> debug

# How to use
- 本地引入debugk
```
//ADebugKit
include ':ADebugKit'
project(':ADebugKit').projectDir = new File("D:\\WorkSpace\\GitHub\\ADebugKit")
include ':ADebugKit:debugk'
//ACrashKit
include ':ACrashKit'
project(':ACrashKit').projectDir = new File("D:\\WorkSpace\\GitHub\\ACrashKit")
include ':ACrashKit:crashk'
//ALogKit
include ':ALogKit'
project(':ALogKit').projectDir = new File("D:\\WorkSpace\\GitHub\\ALogKit")
include ':ALogKit:logk'
//AOptKit_fps
include ':AOptKit_fps'
project(':AOptKit_fps').projectDir = new File("D:\\WorkSpace\\GitHub\\AOptKit_fps")
include ':AOptKit_fps:optk_fps'
//ANavigateKit_Navigation
include ':ANavigateKit_Navigation'
project(':ANavigateKit_Navigation').projectDir = new File("D:\\WorkSpace\\GitHub\\ANavigateKit_Navigation")
include ':ANavigateKit_Navigation:navigatek_navigation'
//AUICoreKit
include ':AUICoreKit'
project(':AUICoreKit').projectDir = new File("D:\\WorkSpace\\GitHub\\AUICoreKit")
include ':AUICoreKit:layoutk_tab'
include ':AUICoreKit:recyclerk'
include ':AUICoreKit:layoutk'
include ':AUICoreKit:vhk'
```
- 本地引入debugk_leakcanary
```
//ADebugKit
include ':ADebugKit'
project(':ADebugKit').projectDir = new File("D:\\WorkSpace\\GitHub\\ADebugKit")
include ':ADebugKit:debugk_leakcanary'
```
