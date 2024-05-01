package br.com.itau.app.analytics


import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics

object ItauAnalytics : Tracker {

   const val SCREEN_NAME = FirebaseAnalytics.Param.SCREEN_NAME
   const val CLICK = "button_click"

   private var analytics: FirebaseAnalytics = com.google.firebase.Firebase.analytics

   override fun logEvent(eventName: String, params: Map<String, Any>) {
      val bundle = createBundleFromMap(params)
      analytics.logEvent(eventName, bundle)
   }

   override fun logEvent(eventName: String, param: String) {
      val bundle = createBundleFromMap(mapOf(eventName to param))
      analytics.logEvent(eventName, bundle)
   }

   private fun createBundleFromMap(params: Map<String, Any>): Bundle {
      val bundle = Bundle()
      for ((key, value) in params) {
         when (value) {
            is String -> bundle.putString(key, value)
            is Int -> bundle.putInt(key, value)
            is Long -> bundle.putLong(key, value)
            is Double -> bundle.putDouble(key, value)
            is Float -> bundle.putFloat(key, value)
            is Boolean -> bundle.putBoolean(key, value)
            else -> bundle.putString(key, value.toString())
         }
      }
      return bundle
   }
}
