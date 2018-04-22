package cn.kisoo.forest.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.view.accessibility.AccessibilityEvent

class WindowChangeService: AccessibilityService(){
    override fun onInterrupt() {
    }

    override fun onCreate() {
        super.onCreate()
        serviceInfo.flags = AccessibilityServiceInfo.FLAG_REQUEST_TOUCH_EXPLORATION_MODE;

    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {

    }

}