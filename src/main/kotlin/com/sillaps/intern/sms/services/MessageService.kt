package com.sillaps.intern.sms.services


interface MessageService {

    fun sendSms(phone:String , message: String) : String

}