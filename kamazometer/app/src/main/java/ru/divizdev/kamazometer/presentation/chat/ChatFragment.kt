package ru.divizdev.kamazometer.presentation.chat


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.stfalcon.chatkit.commons.ImageLoader
import com.stfalcon.chatkit.messages.MessageInput
import com.stfalcon.chatkit.messages.MessagesListAdapter
import kotlinx.android.synthetic.main.fragment_chat.*
import ru.divizdev.kamazometer.R
import java.util.*


class ChatFragment : Fragment() {

    private val me = User("2", "Я", "")
    private val user = User("1", "Оператор", "")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageLoader = ImageLoader { imageView, url ->

            Picasso.get().load(url).into(imageView)
        }
        val adapter = MessagesListAdapter<Message>("2", imageLoader)
        adapter.addToEnd(getMessages(), true)

        messagesList.setAdapter(adapter, true)

        inputView.setInputListener(MessageInput.InputListener {
            //validate and send message
            adapter.addToStart(Message("28", Date(), User("2", "Я", ""), it.toString()), true)
            true
        })
    }

    private fun getMessages(): List<Message> {
        val listDate = mutableListOf<Date>()
        val instance = Calendar.getInstance()
        instance.set(2018, 7, 23, 15, 45, 0)
        listDate.add(instance.time)
        instance.set(2018, 7, 23, 15, 46, 45)
        listDate.add(instance.time)
        instance.set(2018, 7, 23, 15, 56, 45)
        listDate.add(instance.time)
        instance.set(2018, 7, 23, 22, 36, 45)
        listDate.add(instance.time)
        instance.set(2018, 7, 23, 22, 36, 45)
        listDate.add(instance.time)
        instance.set(2018, 7, 23, 22, 48, 45)
        listDate.add(instance.time)



        return listOf(
                Message("1", listDate[0], user, "При подъезде к погрузке, будьте аккуратнее."),
                Message("2", listDate[1], user, "Прошел сильный дождь на дороге скользко."),
                Message("3", listDate[2], me, "Принял, спасибо"),
                Message("4", listDate[3], me, "Во Владимире перед разгрузкой все перекопанно"),
                Message("5", listDate[4], me, "", "http://divizdev.ru/wordpress/wp-content/uploads/2018/08/IMG_20180823_102636.png"),
                Message("6", listDate[5], user, "Спасибо за информацию")
        )

    }
}
