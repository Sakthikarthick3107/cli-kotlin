package com.kotl

import android.content.Context
import android.os.BatteryManager
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class BatteryModule(private val reactContext: ReactApplicationContext):ReactContextBaseJavaModule(reactContext) {
    override fun getName(): String {
        return "BatteryModule"
    }
    @ReactMethod
    fun getBatteryLevel(promise: Promise){
        val batteryManager = reactContext.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        val batteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)

        if(batteryLevel != -1){
            promise.resolve(batteryLevel.toDouble()/100.0)
        }
        else{
            promise.reject("Unavailable","Battery level not available")
        }
    }

}