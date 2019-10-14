package ru.divizdev.kamazometer.presentation.history.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_history.*
import ru.divizdev.kamazometer.R
import ru.divizdev.kamazometer.presentation.history.Order
import ru.divizdev.kamazometer.presentation.history.adapter.HistoryAdapter


class HistoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val linearLayout = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        history_list.layoutManager = linearLayout
        history_list.adapter = HistoryAdapter(listOf(
                Order("ORD000040", "Выполнен", "22.08.2018 - 23.08.2018", "Радонежская ферма, Москва, Железнодорожый проезд, 4", "Молокозавод, Люберцы, Московский проспект, 13", "15 000,00 \u20BD"),
                Order("ORD000038", "Выполнен", "22.08.2018 - 22.08.2018", "Буренка, Москва, Никулино, Покрышкина, 7", "Молокозавод, Люберцы, Московский проспект, 13", "12 000,00 \u20BD"),
                Order("ORD000035", "Оплачен", "21.08.2018 - 22.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13", "8 000,00 \u20BD"),
                Order("ORD000036", "Оплачен", "20.08.2018 - 20.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13", "15 000,00 \u20BD"),
                Order("ORD000023", "Оплачен", "20.08.2018 - 20.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13", "15 000,00 \u20BD"),
                Order("ORD000038", "Оплачен", "20.08.2018 - 20.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13", "12 000,00 \u20BD"),
                Order("ORD000036", "Оплачен", "19.08.2018 - 19.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13","12 000,00 \u20BD"),
                Order("ORD000035", "Оплачен", "19.08.2018 - 19.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13","16 000,00 \u20BD"),
                Order("ORD000034", "Оплачен", "19.08.2018 - 19.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13","14 000,00 \u20BD"),
                Order("ORD000033", "Оплачен", "18.08.2018 - 18.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13","11 000,00 \u20BD"),
                Order("ORD000032", "Оплачен", "18.08.2018 - 18.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13","10 000,00 \u20BD"),
                Order("ORD000031", "Оплачен", "18.08.2018 - 18.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000030", "Оплачен", "17.08.2018 - 17.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000029", "Оплачен", "17.08.2018 - 17.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000028", "Оплачен", "17.08.2018 - 17.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000027", "Оплачен", "16.08.2018 - 16.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000026", "Оплачен", "16.08.2018 - 16.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000025", "Оплачен", "16.08.2018 - 16.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000024", "Оплачен", "15.08.2018 - 15.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000023", "Оплачен", "15.08.2018 - 15.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000022", "Оплачен", "15.08.2018 - 15.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000021", "Оплачен", "14.08.2018 - 14.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000020", "Оплачен", "14.08.2018 - 14.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000019", "Оплачен", "14.08.2018 - 14.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000018", "Оплачен", "13.08.2018 - 13.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000017", "Оплачен", "13.08.2018 - 13.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000016", "Оплачен", "13.08.2018 - 13.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000015", "Оплачен", "12.08.2018 - 12.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13"),
                Order("ORD000014", "Оплачен", "12.08.2018 - 12.08.2018", "Москва, Поселение Вороновское Россия, 8 км", "Молокозавод, Люберцы, Московский проспект, 13")
        ))



        super.onViewCreated(view, savedInstanceState)


    }


}
