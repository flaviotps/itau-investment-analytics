package br.com.itau.app.analytics

interface Tracker {
    fun logEvent(eventName: String, params: Map<String, Any>)
    fun logEvent(eventName: String, param: String)
}