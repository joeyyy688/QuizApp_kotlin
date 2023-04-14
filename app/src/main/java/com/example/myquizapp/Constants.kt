package com.example.myquizapp

object Constants {
    fun getQuestions() : List<Question>{
        return listOf(
            Question(1,
                "What country does this flag belong to",
                R.drawable.ic_flag_of_argentina,
                arrayListOf("Ghana", "Argentina", "Serbia", "Romania"),
                1
            ),
            Question(2,
                "What country does this flag belong to",
                R.drawable.ic_flag_of_australia,
                arrayListOf("Senegal", "Canada", "USA", "Australia"),
                3
            ),
            Question(3,
                "What country does this flag belong to",
                R.drawable.ic_flag_of_belgium,
                arrayListOf("Belgium", "South Africa", "Tanzania", "France"),
                0
            ),
            Question(4,
                "What country does this flag belong to",
                R.drawable.ic_flag_of_brazil,
                arrayListOf("UK", "Japan", "Brazil", "Cuba"),
                2
            ),
            Question(5,
                "What country does this flag belong to",
                R.drawable.ic_flag_of_denmark,
                arrayListOf("Denmark", "Italy", "Germany", "Russia"),
                0
            ),
            Question(6,
                "What country does this flag belong to",
                R.drawable.ic_flag_of_fiji,
                arrayListOf("France", "Fiji", "Togo", "Austria"),
                1
            ),
            Question(7,
                "What country does this flag belong to",
                R.drawable.ic_flag_of_germany,
                arrayListOf("France", "Sudan", "Syria", "Germany"),
                3
            ),
            Question(8,
                "What country does this flag belong to",
                R.drawable.ic_flag_of_india,
                arrayListOf("China", "India", "Ukraine", "Sweden"),
                1
            ),
            Question(9,
                "What country does this flag belong to",
                R.drawable.ic_flag_of_kuwait,
                arrayListOf("South Africa", "Mexico", "Haiti", "Kuwait"),
                3
            ),
            Question(10,
                "What country does this flag belong to",
                R.drawable.ic_flag_of_new_zealand,
                arrayListOf("Jamaica", "Egypt", "New ZeaLand", "Tanzania"),
                2
            ),
        )
    }

}