package ru.divizdev.kamazometer.presentation.chat

import com.stfalcon.chatkit.commons.models.IMessage
import com.stfalcon.chatkit.commons.models.IUser
import com.stfalcon.chatkit.commons.models.MessageContentType
import java.util.*



class Message(private val id: String, private val date: Date, private val user: User, private val message: String, private val urlImage: String? = null ): IMessage,  MessageContentType.Image {


    override fun getImageUrl(): String? {
        return urlImage
    }


    override fun getId(): String {
        return id
    }

    override fun getCreatedAt(): Date {
        return date
    }

    override fun getUser(): IUser {
        return user
    }

    override fun getText(): String {
        return message
    }
}

class User(private val id: String, private val name: String, private val avatar: String): IUser{
    override fun getName(): String {
         return name
    }

    override fun getId(): String {
        return id
    }

    override fun getAvatar(): String {
        return avatar
    }

}

