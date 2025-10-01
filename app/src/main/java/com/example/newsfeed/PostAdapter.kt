package com.example.newsfeed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsfeed.databinding.PostItemBinding
class PostAdapter(

) : RecyclerView.Adapter<PostAdapter.PostHolder>() {
    val postList = ArrayList<Post>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item,parent,false)
        return PostHolder(view)
    }

    override fun onBindViewHolder(
        holder: PostHolder,
        position: Int
    ) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    inner class PostHolder(item: View) : RecyclerView.ViewHolder(item){
        val binding = PostItemBinding.bind(item)
        fun bind(post: Post) = with(binding){
            Glide.with(itemView.context)
                .load(post.imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(im)
            tvTitle.text = post.description
            btnLike.setImageResource(
                if (post.isLiked) R.drawable.ic_heart_filled
                else R.drawable.ic_heart_outline
            )

            btnLike.setOnClickListener {
                post.isLiked = !post.isLiked
                this@PostAdapter.notifyItemChanged(adapterPosition)
            }




        }
    }
    fun addPost(post: Post){
        postList.add(post)
        notifyDataSetChanged()
    }
}
