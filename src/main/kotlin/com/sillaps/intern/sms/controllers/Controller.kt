package com.sillaps.intern.sms.controllers

import com.sillaps.intern.sms.models.Sms
import com.sillaps.intern.sms.services.MessageService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class Controller {

    companion object {
        val logger = LoggerFactory.getLogger(Controller::class.java)
    }

    @Autowired
    lateinit var messageService: MessageService

    /*
    @RequestMapping(value = "/", method = arrayOf(RequestMethod.GET))
    fun start(Message: Model): String {
        Message.addAttribute("sms", Sms())
        return "messageView"
    }
    */

    @RequestMapping(value = "/", method = arrayOf(RequestMethod.POST))
    fun check(@Valid message: Sms): Any {
        val id = messageService.sendSms(message.num, message.msg)
        return mapOf("status" to "OK", "id" to id)
    }


}