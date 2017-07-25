package com.sillaps.intern.sms

import com.sillaps.intern.sms.services.MessageService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    lateinit var messageService: MessageService

    @Test
    fun testSms() {
        messageService.sendSms("+212675056018", "Unit test")
    }

}
