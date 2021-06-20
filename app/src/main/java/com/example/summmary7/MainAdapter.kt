package com.example.summmary7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.summmary7.data.network.models.Summary
import com.example.summmary7.databinding.ItemActionRecyclerviewBinding
import com.example.summmary7.extensions.hide
import com.example.summmary7.extensions.setImage

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    var summaries = listOf<Summary>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemActionRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = summaries.size

    inner class MainViewHolder(private val binding: ItemActionRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        lateinit var model: Summary

        fun onBind() {
            model = summaries[adapterPosition]

            if (model.team1Action != null) {
                model.team1Action.forEach { team1 ->
                    when (team1.actionType) {
                        1 -> {
                            binding.tvPlayer1Name.text = team1.action.player.playerName
                            binding.ivPlayer1.setImage(team1.action.player.playerImage)
                            binding.ivTeam1Action.setImage(R.mipmap.goal_green)
                            binding.tvTeam1Minute.text = model.actionTime
                            binding.ivTeam11Action.hide()
                            binding.tvPlayer11Name.hide()
                            binding.ivPlayer11.hide()
                        }
                        2 -> {
                            binding.tvPlayer1Name.text = team1.action.player.playerName
                            binding.ivPlayer1.setImage(team1.action.player.playerImage)
                            binding.tvTeam1Minute.text = model.actionTime
                            binding.ivTeam1Action.setImage(R.mipmap.card_yellow)
                            binding.tvTeam1Action.text = "Tripping"
                            binding.ivTeam11Action.hide()
                            binding.tvPlayer11Name.hide()
                            binding.ivPlayer11.hide()
                        }
                        3 -> {
                            binding.tvPlayer1Name.text = team1.action.player.playerName
                            binding.ivPlayer1.setImage(team1.action.player.playerImage)
                            binding.tvTeam1Minute.text = model.actionTime
                            binding.ivTeam1Action.setImage(R.mipmap.card_red)
                            binding.tvTeam1Action.text = "Tripping"
                            binding.ivTeam11Action.hide()
                            binding.tvPlayer11Name.hide()
                            binding.ivPlayer11.hide()
                        }
                        else -> {
                            binding.tvTeam1Minute.text = model.actionTime
                            binding.tvTeam1Action.text = "Substitution"
                            binding.tvPlayer1Name.text = team1.action.player1.playerName
                            binding.ivPlayer1.setImage(team1.action.player1.playerImage)
                            binding.ivTeam1Action.setImage(R.mipmap.arrow_green)

                            binding.tvPlayer11Name.text = team1.action.player2.playerName
                            binding.ivPlayer11.setImage(team1.action.player2.playerImage)
                            binding.ivTeam11Action.setImage(R.mipmap.arrow_red)

                        }
                    }
                }
            } else {
                binding.lyTeam1.hide()
            }

            if (model.team2Action != null) {
                model.team2Action.forEach { team2 ->
                    when (team2.actionType) {
                        1 -> {
                            binding.tvPlayer2Name.text = team2.action.player.playerName
                            binding.ivPlayer2.setImage(team2.action.player.playerImage)
                            binding.ivTeam2Action.setImage(R.mipmap.goal_green)
                            binding.tvTeam2Minute.text = model.actionTime
                            binding.ivTeam22Action.hide()
                            binding.tvPlayer22Name.hide()
                            binding.ivPlayer22.hide()
                        }
                        2 -> {
                            binding.tvPlayer2Name.text = team2.action.player.playerName
                            binding.ivPlayer2.setImage(team2.action.player.playerImage)
                            binding.tvTeam2Minute.text = model.actionTime
                            binding.ivTeam2Action.setImage(R.mipmap.card_yellow)
                            binding.tvTeam2Action.text = "Tripping"
                            binding.ivTeam22Action.hide()
                            binding.tvPlayer22Name.hide()
                            binding.ivPlayer22.hide()
                        }
                        3 -> {
                            binding.tvPlayer2Name.text = team2.action.player.playerName
                            binding.ivPlayer2.setImage(team2.action.player.playerImage)
                            binding.tvTeam2Minute.text = model.actionTime
                            binding.ivTeam2Action.setImage(R.mipmap.card_red)
                            binding.tvTeam2Action.text = "Tripping"
                            binding.ivTeam22Action.hide()
                            binding.tvPlayer22Name.hide()
                            binding.ivPlayer22.hide()
                        }
                        else -> {
                            binding.tvTeam2Minute.text = model.actionTime
                            binding.tvTeam2Action.text = "Substitution"
                            binding.tvPlayer2Name.text = team2.action.player1.playerName
                            binding.ivPlayer2.setImage(team2.action.player1.playerImage)
                            binding.ivTeam1Action.setImage(R.mipmap.arrow_green)

                            binding.tvPlayer22Name.text = team2.action.player2.playerName
                            binding.ivPlayer22.setImage(team2.action.player2.playerImage)
                            binding.ivTeam22Action.setImage(R.mipmap.arrow_red)
                        }
                    }
                }
            } else {
                binding.lyTeam2.hide()
            }
        }
    }

    fun updateData(data: List<Summary>) {
        summaries = data
        notifyDataSetChanged()
    }
}
