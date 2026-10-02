package com.example.myapplication

data class Question(
    val statement: String,
    val isHack: Boolean,
    val explanation: String
)

val questions = listOf(
    Question("Putting your phone in uncooked rice can help save a wet phone.", true, "Hack - Rice absorbs moisture, silica gel works even better."),
    Question("You can charge your phone by microwaving it for 30 seconds.", false, "Myth - Extremely dangerous, will destroy phone."),
    Question("White vinegar and baking soda can unclog a slow drain.", true, "Hack - Fizzing reaction helps break down gunk."),
    Question("You can unlock any car with a tennis ball with a hole.", false, "Myth - Viral legend, doesn't work on modern cars."),
    Question("Freezing jeans kills bacteria and removes odor.", true, "Hack - Freezing kills odor bacteria quickly.")
)