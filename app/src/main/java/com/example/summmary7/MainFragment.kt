package com.example.summmary7

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.summmary7.data.network.models.ResultModel
import com.example.summmary7.databinding.FragmentMainBinding
import com.example.summmary7.extensions.setImage
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels()

    lateinit var mainAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)

        viewModel.getData()
        initAdapter()
        observer()



        return binding.root
    }


    private fun observer() {
        viewModel.data.observe(viewLifecycleOwner, {
            mainAdapter.updateData(it.match.matchSummary.summaries)

            binding.tvDate.text = it.match.matchDate.toString()
            binding.tvStadium.text = it.match.stadiumAdress
            binding.ivTeam1.setImage(it.match.team1.teamImage)
            binding.tvTeam1Name.text = it.match.team1.teamName
            binding.tvTeam1Score.text = it.match.team1.score.toString()
            binding.tvTeam2Score.text = it.match.team2.score.toString()
            binding.tvTeam2Name.text = it.match.team2.teamName
            binding.ivTeam2.setImage(it.match.team2.teamImage)
            binding.tvTeam1BallPossession.text = it.match.team1.ballPosition.toString()
            binding.tvTeam2BallPossession.text = it.match.team2.ballPosition.toString()
            binding.tvMatchTime.text = it.match.matchTime.toString()

        })
    }

    private fun initAdapter() {
        mainAdapter = MainAdapter()
        binding.rv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mainAdapter
        }
    }

}
