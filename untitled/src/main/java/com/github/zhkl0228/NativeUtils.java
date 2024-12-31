package com.github.zhkl0228;

import com.github.unidbg.AndroidEmulator;
import com.github.unidbg.LibraryResolver;
import com.github.unidbg.Module;
import com.github.unidbg.arm.backend.DynarmicFactory;
import com.github.unidbg.arm.backend.KvmFactory;
import com.github.unidbg.arm.backend.Unicorn2Factory;
import com.github.unidbg.linux.android.AndroidEmulatorBuilder;
import com.github.unidbg.linux.android.AndroidResolver;
import com.github.unidbg.linux.android.dvm.*;
import com.github.unidbg.memory.Memory;
import com.github.unidbg.virtualmodule.android.AndroidModule;
import com.github.unidbg.virtualmodule.android.JniGraphics;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class NativeUtils extends AbstractJni {

    private static LibraryResolver createLibraryResolver() {
        return new AndroidResolver(23);
    }

    private static AndroidEmulator createARMEmulator() {
        return AndroidEmulatorBuilder
                .for64Bit()
                .setProcessName("com.iqiyi.i18n")
                .addBackendFactory(new DynarmicFactory(true))
                .addBackendFactory(new KvmFactory(true))
                .addBackendFactory(new Unicorn2Factory(true))
                .build();
    }

    private final AndroidEmulator emulator;
    private final VM vm;
    private final DvmClass Native;

    public NativeUtils(String apkPath, String soPath, String className) throws IOException {
        emulator = createARMEmulator();
        final Memory memory = emulator.getMemory();
        memory.setLibraryResolver(createLibraryResolver());
        File apk = new File(Objects.requireNonNull(getClass().getClassLoader()).getResource(apkPath).getFile());
        vm = emulator.createDalvikVM(apk);
        vm.setJni(this);
        Module module = new JniGraphics(emulator, vm).register(memory);
        assert module != null;
        new AndroidModule(emulator, vm).register(memory);

        vm.setVerbose(false);
        File so = new File(Objects.requireNonNull(getClass().getClassLoader()).getResource(soPath).getFile());
        DalvikModule dm = vm.loadLibrary(so, true);
        dm.callJNI_OnLoad(emulator);

        Native = vm.resolveClass(className);
    }

    void destroy() throws IOException {
        emulator.close();
    }




    @Override
    public DvmObject<?> callObjectMethodV(BaseVM vm, DvmObject<?> dvmObject, String signature, VaList vaList) {
        if ("android/content/Context->getPackageResourcePath()Ljava/lang/String;".equals(signature)) {
            return new StringObject(
                    vm,
                    "/data/app/com.iqiyi.i18n/base.apk"
            );
        }
        return super.callObjectMethodV(vm, dvmObject, signature, vaList);
    }



    public void getVf(String dashParam) {
        String methodSign = "getQdvfJNI(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;";
        DvmObject<?> context = vm.resolveClass("android/content/Context").newObject(null);
        vm.addLocalObject(context);
        DvmObject<?> ret = Native.callStaticJniMethodObject(emulator, methodSign,
                context,
                dashParam, "iqiyi"
        );
        String res = (String) ret.getValue();
        System.out.println("vf " + res);
    }

}