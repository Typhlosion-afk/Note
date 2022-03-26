package com.dore.dorenote.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dore.dorenote.R
import com.dore.dorenote.adapter.PlanningTagAdapter
import com.dore.dorenote.adapter.UpComingAdapter
import com.dore.dorenote.model.Planning

class HomeFragment : Fragment() {

    private lateinit var rootView : View

    private var listPlanning = ArrayList<Planning>()

    private lateinit var mTagRecyclerView: RecyclerView

    private lateinit var mUpComingRecyclerView: RecyclerView

    private lateinit var mUpComingAdapter: UpComingAdapter

    private lateinit var mPlanningTagAdapter: PlanningTagAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)

        initData()
        initAdapter()

        return rootView
    }

    private fun initData() {
        listPlanning.clear()
        listPlanning.add(Planning("Tên 1", "Tag Name 1", "time 1"))
        listPlanning.add(Planning("Tên 2", "Tag Name 2", "time 2"))
        listPlanning.add(Planning("Tên 3", "Tag Name 3", "time 3"))
        listPlanning.add(Planning("Tên 4", "Tag Name 4", "time 4"))
        listPlanning.add(Planning("Tên 5", "Tag Name 5", "time 5"))
        listPlanning.add(Planning("Tên 6", "Tag Name 6", "time 6"))
        listPlanning.add(Planning("Tên 7", "Tag Name 7", "time 7"))
        listPlanning.add(Planning("Tên 8", "Tag Name 8", "time 8"))
        listPlanning.add(Planning("Tên 9", "Tag Name 9", "time 9"))
        listPlanning.add(Planning("Tên 10", "Tag Name 10", "time 10"))
        listPlanning.add(Planning("Tên 11", "Tag Name 11", "time 11"))
        listPlanning.add(Planning("Tên 12", "Tag Name 12", "time 12"))

    }

    private fun initAdapter() {
        mTagRecyclerView = rootView.findViewById(R.id.recycle_container)
        mPlanningTagAdapter = PlanningTagAdapter(rootView.context, listPlanning)
        mTagRecyclerView.isNestedScrollingEnabled = true
        LinearLayoutManager(rootView.context, RecyclerView.HORIZONTAL, false)
            .apply {
                mTagRecyclerView.layoutManager = this
            }

        mTagRecyclerView.adapter = mPlanningTagAdapter

        mUpComingRecyclerView = rootView.findViewById(R.id.recycle_upcoming)
        mUpComingAdapter = UpComingAdapter(rootView.context, listPlanning)
        mUpComingRecyclerView.isNestedScrollingEnabled = false
        LinearLayoutManager(rootView.context, RecyclerView.VERTICAL, false)
            .apply {
                mUpComingRecyclerView.layoutManager = this
            }

        mUpComingRecyclerView.adapter = mUpComingAdapter
    }

}