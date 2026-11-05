package com.mobiletools.systemhelper.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.mobiletools.systemhelper.service.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0019a extends Binder implements a {
        public AbstractBinderC0019a() {
            attachInterface(this, "com.mobiletools.systemhelper.service.IRegisterHelperService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 >= 1 && i2 <= 16777215) {
                parcel.enforceInterface("com.mobiletools.systemhelper.service.IRegisterHelperService");
            }
            if (i2 == 1598968902) {
                parcel2.writeString("com.mobiletools.systemhelper.service.IRegisterHelperService");
                return true;
            }
            if (i2 == 1) {
                c(parcel.readString());
            } else if (i2 == 2) {
                a(parcel.readInt());
            } else {
                if (i2 != 3) {
                    if (i2 == 4) {
                        d(parcel.readInt() != 0);
                    } else {
                        if (i2 != 5) {
                            return super.onTransact(i2, parcel, parcel2, i3);
                        }
                        boolean zB = b();
                        parcel2.writeNoException();
                        parcel2.writeInt(zB ? 1 : 0);
                    }
                    return true;
                }
                e();
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i2);

    boolean b();

    void c(String str);

    void d(boolean z2);

    void e();
}
