#crashlytics
-keep class com.crashlytics.** { *; }
-keep class com.crashlytics.android.** { *; }
-keepattributes SourceFile,LineNumberTable

#spongycastle
-keep class org.spongycastle.** { *; }
-dontwarn org.spongycastle.**

#OkHttp
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**
# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

#Retrofit
-dontwarn retrofit2.Platform
-dontwarn retrofit2.Platform$Java8
-keepattributes Signature
-keepattributes Exceptions

#Leak Canary
-keep class com.squareup.leakcanary.** { *; }
-keep class org.eclipse.mat.** { *; }

#Testing (NA)
-dontnote junit.framework.**
-dontnote junit.runner.**
-dontwarn android.test.**
-dontwarn android.support.test.**
-dontwarn org.junit.**
