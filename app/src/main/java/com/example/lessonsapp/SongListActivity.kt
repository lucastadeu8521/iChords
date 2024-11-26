package com.example.lessonsapp


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lessonsapp.databinding.ActivitySongListBinding
import com.ferfalk.simplesearchview.SimpleSearchView


class SongListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySongListBinding

    private lateinit var adapter: SongRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)



        val recyclerView = binding.rvSongList

        val songList = listOf(

            SongModel("Scar Tissue", "Red Hot Chilli Peppers","Californication",R.drawable.scar_tissue,"INDIE",
                "Scar tissue that I wish you saw\n" +
                        "Sarcastic mister know-it-all\n" +
                        "Close your eyes and I'll kiss you, 'cause\n" +
                        "With the birds I'll share\n"),

            SongModel("Hunting High and Low", "a-ha", "Hunting High and Low", R.drawable.aha,"R&B",
                "Here I am\n" +
                        "And within the reach of my hands\n" +
                        "She's sound asleep\n" + 
                        "And she's sweeter now than the wildest dream\n" +
                        "Could've seen her\n" +
                        "And I watch her slipping away"),

            SongModel("All For Us", "Labrinth", "Imagination & the Misfit Kid", R.drawable.all_for_us,"POP",
                "dakshjdjkhashdjkashjkd\n"+
                        "I've been tryna call\n" +
                        "I've been on my own for long enough\n" +
                        "Maybe you can show me how to love, maybe\n" +
                        "I'm going through withdrawals\n" +
                        "You don't even have to do too much\n" +
                        "You can turn me on with just a touch, baby"),

            SongModel("Bouncy", "ATEEZ", "The World EP.2: Outlaw", R.drawable.bouncy,"KPOP",
                "What you gonna say? (Yeah)\n" +
                        "Sit back and relax, man (hoo)\n" +
                        "Don't you wanna bet, man?\n" +
                        "I got time but it's not for you, bro\n" +
                        "Don't you realize what I'm saying? (Let's go, let's go)\n" +
                        "What you gonna do? Ayy, let's go"),

            SongModel("Blinding Lights", "The Weenknd", "After Hours", R.drawable.the_weeknd,"R&B",
                "Yeah\n" +
                        "I've been tryna call\n" +
                        "I've been on my own for long enough\n" +
                        "Maybe you can show me how to love, maybe\n" +
                        "I'm going through withdrawals\n" +
                        "You don't even have to do too much\n" +
                        "You can turn me on with just a touch, baby"),

            SongModel("Cigarette Daydreams", "Cage The Elephant", "Melophobia", R.drawable.cigarette_daydreams,"INDIE",
                "Did you stand there all alone?\n" +
                        "Oh, I cannot explain what's goin' down\n" +
                        "I can see you standin' next to me\n" +
                        "In and out somewhere else right now\n" +
                        "You sigh, look away\n" +
                        "I can see it clear as day\n" +
                        "Close your eyes, so afraid\n" +
                        "Hide behind that baby face"),

            SongModel("Roar", "Katy Perry", "Prism", R.drawable.roar,"POP",
                "I used to bite my tongue and hold my breath\n" +
                        "Scared to rock the boat and make a mess\n" +
                        "So I sat quietly, agreed politely\n" +
                        "I guess that I forgot I had a choice\n" +
                        "I let you push me past the breaking point\n" +
                        "I stood for nothing, so I fell for everything"),

            SongModel("Pumped Up Kicks", "Foster The People", "Torches", R.drawable.pumped_up_kicks,"INDIE",
                "Robert's got a quick hand\n" +
                        "He'll look around the room, he won't tell you his plan\n" +
                        "He's got a rolled cigarette\n" +
                        "Hanging out his mouth, he's a cowboy kid"),

            SongModel("Poema", "Ney Matogrosso", "Olhos de Farol", R.drawable.poema,"MPB",
                "Eu hoje tive um pesadelo e levantei atento, a tempo\n" +
                        "Eu acordei com medo e procurei no escuro alguém com seu carinho\n" +
                        "E lembrei de um tempo\n" +
                        "Porque o passado me traz uma lembrança\n" +
                        "Do tempo que eu era criança\n" +
                        "E o medo era motivo de choro\n" +
                        "Desculpa pra um abraço ou um consolo"),

            SongModel("Viva La Vida", "Coldplay", "Viva la Vida or Death and All His Friends", R.drawable.coldplay, "INDIE",
                    "I used to rule the world\n" +
                            "Seas would rise when I gave the word\n" +
                            "Now in the morning, I sleep alone\n" +
                            "Sweep the streets I used to own"),

            SongModel("September", "Earth, Wind & Fire", " The Best of Earth, Wind & Fire, Vol. 1", R.drawable.setember,"R&B",
                "Do you remember\n" +
                        "The 21st night of September?\n" +
                        "Love was changin' the minds of pretenders\n" +
                        "While chasin' the clouds away"),
        )



        // Configura o adapter e o layout manager da RecyclerView
        adapter = SongRecyclerAdapter(this, songList) { selectedSong ->
            val intent = Intent(this, SongDetailsActivity::class.java).apply {
                putExtra("songTitle", selectedSong.title)
                putExtra("songArtist", selectedSong.artist)
                putExtra("songAlbum", selectedSong.album)
                putExtra("songImage", selectedSong.image)
                putExtra("songLyrics", selectedSong.letter)
            }
            startActivity(intent)
        }

        binding.rvSongList.layoutManager = LinearLayoutManager(this)
        binding.rvSongList.adapter = adapter

        initSearchView()
    }

    private fun initSearchView() {
        binding.searchView.setOnQueryTextListener(object : SimpleSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter.search(newText) // Call the search method of the adapter
                return true
            }

            override fun onQueryTextCleared(): Boolean {
                adapter.search("") // Clear the search when the text is cleared
                return true
            }
        })

        binding.searchView.setOnSearchViewListener(object : SimpleSearchView.SearchViewListener {
            override fun onSearchViewShown() {
                Log.d("SimpleSearchView", "onSearchViewShown")
            }

            override fun onSearchViewClosed() {
                Log.d("SimpleSearchView", "onSearchViewClosed")
                adapter.search("") // Reset the search when the view is closed
            }

            override fun onSearchViewShownAnimation() {
                Log.d("SimpleSearchView", "onSearchViewShownAnimation")
            }

            override fun onSearchViewClosedAnimation() {
                Log.d("SimpleSearchView", "onSearchViewClosedAnimation")
            }
        })
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId== R.id.menu_search){

        }else{

        }
        return super.onOptionsItemSelected(item)
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_bar, menu)

        val item = menu!!.findItem(R.id.menu_search)
            binding.searchView.setMenuItem(item)

        return true
    }
}
