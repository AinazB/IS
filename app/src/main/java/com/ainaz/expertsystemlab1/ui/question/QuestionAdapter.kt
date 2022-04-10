package com.ainaz.expertsystemlab1.ui.question

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.core.view.allViews
import androidx.core.view.children
import androidx.core.view.forEach
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ainaz.expertsystemlab1.data.questionWithAnswers.QuestionWithAnswers
import com.ainaz.expertsystemlab1.databinding.QuestionListItemBinding

class QuestionAdapter(
    val items: ArrayList<QuestionWithAnswers> = arrayListOf()
) : RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int): Int = position

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding =
            QuestionListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) =
        holder.bind(items[position])

    fun setQuestions(questions: List<QuestionWithAnswers>) {
        items.clear()
        items.addAll(questions)
    }

    inner class QuestionViewHolder(private val binding: QuestionListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(questionWithAnswers: QuestionWithAnswers) {
            binding.questionText.text = questionWithAnswers.question.questionText
            if (binding.answersGroup.childCount == 0) {
                questionWithAnswers.answers.forEach { answer ->
                    val answerBox = CheckBox(this.binding.root.context)
                    answerBox.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    answerBox.text = answer.answer
                    if (answerBox.text == answer.answer)
                        answerBox.isSelected = answer.isSelected
                    binding.answersGroup.addView(answerBox)

                    answerBox.setOnCheckedChangeListener { _, _ ->
                        if (answerBox.text == answer.answer) {
                            answer.isSelected = answerBox.isChecked
                        }
                    }
                }
            }
        }
    }
}