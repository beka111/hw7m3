import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.arch.core.util.Function
import androidx.recyclerview.widget.RecyclerView
import com.example.hw7m3.ItemMusic

import com.example.hw7m3.SecondActivity
import com.example.hw7m3.databinding.ItemMusicBinding

class AdapterMusic(
    val musicList: ArrayList<ItemMusic>,
    private var onClick: Function<Int, Unit>
) : RecyclerView.Adapter<AdapterMusic.ViewHolder>() {

    class ViewHolder(private var binding: ItemMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(music: ItemMusic) {
            binding.tvSong.text = music.name
            binding.tvTime.text = music.author
            binding.tvTime.text = music.time
            binding.tvPosition.text = music.position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMusicBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = musicList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(musicList[position])
        holder.itemView.setOnClickListener {
            val name = musicList[position].name
            val intent = Intent(holder.itemView.context, SecondActivity::class.java)
            intent.putExtra("key", name)
            holder.itemView.context.startActivity(intent)
        }
    }
}