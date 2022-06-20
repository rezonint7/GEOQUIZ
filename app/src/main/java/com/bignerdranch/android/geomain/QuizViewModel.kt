package com.bignerdranch.android.geomain

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
class QuizViewModel : ViewModel() {
    var currentIndex = 0
    var countCorrect:Int = 0
    var countAnswers: Int = 0

    private  val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast,false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    val currentQuestionBankSize: Int get()= questionBank.size
    val currentQuestionAnswer: Boolean get() =
        questionBank[currentIndex].answer
    val currentQuestionText: Int get() =
        questionBank[currentIndex].textResId
    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
    fun moveToPrev(){
        if(currentIndex == 0) currentIndex =+ questionBank.size
        currentIndex = (currentIndex - 1) % questionBank.size
    }
    fun incAnswers() {countAnswers += 1}
    fun incCorrectAnswers() {countCorrect += 1}
}