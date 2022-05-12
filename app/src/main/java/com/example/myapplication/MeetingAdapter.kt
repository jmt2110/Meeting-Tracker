package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_meeting.view.*


class MeetingAdapter(
    val meetings: MutableList<Meeting>
): RecyclerView.Adapter<MeetingAdapter.MeetingViewHolder>() {

class MeetingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetingViewHolder {
        return MeetingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_meeting, parent, false))
    }

    override fun onBindViewHolder(holder: MeetingViewHolder, position: Int) {
        val currentMeeting = meetings[position]
        holder.itemView.apply {
            meetingWho.text = currentMeeting.who
            meetingDate.text = currentMeeting.date
            meetingTime.text = currentMeeting.time
            meetingLocation.text = currentMeeting.location
            meetingAdditional.text = currentMeeting.additional
            idPriorityNotify.text = ""
            if (currentMeeting.priority){
                idPriorityNotify.text = "Priority"
            }
        }
    }

    override fun getItemCount(): Int {
        return meetings.size
    }

    fun addMeeting(meeting: Meeting){
        meetings.add(meeting)
        notifyItemInserted(meetings.size - 1)
    }
}
