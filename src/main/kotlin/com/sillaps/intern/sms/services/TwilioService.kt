package com.sillaps.intern.sms.services

import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct


@Service
class TwilioService : MessageService {

    companion object {

        var logger = LoggerFactory.getLogger(TwilioService::class.java)

    }

    @Value("\${twilio.account-sid}")
    private var accountSid: String = ""

    @Value("\${twilio.auth-token}")
    private var authToken: String = ""

    @Value("\${twilio.phone-number}")
    private var phoneNumber: String = ""

    override fun sendSms(phone: String, message: String) : String {
        logger.debug("Sending message to : ${ phone }")
        val res = Message.creator(PhoneNumber(phone), PhoneNumber(phoneNumber), message).create()
        logger.debug("Message sent with id: ${ res.sid }")
        return res.sid
    }

    @PostConstruct
    fun initialize() {
        Twilio.init(accountSid, authToken)
        logger.info("Twilio API initialized with SID: ${ accountSid }")
    }


}