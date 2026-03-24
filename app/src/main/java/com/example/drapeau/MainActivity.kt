package com.example.drapeau

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drapeau.ui.theme.DrapeauTheme

data class Country(
    val name: String,
    val capital: String,
    val code: String,
    val flagRes: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DrapeauTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CountryListScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CountryItem(country: Country, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = country.flagRes),
                contentDescription = "Drapeau de ${country.name}",
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = country.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Capitale : ${country.capital}",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "Code : ${country.code}",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}

@Composable
fun CountryListScreen(modifier: Modifier = Modifier) {
    val countries = listOf(
        Country("Cote d'Ivoire", "Yamoussoukro", "CI", R.drawable.c),
        Country("Egypte", "Le Caire", "EG", R.drawable.e),
        Country("Nigeria", "Abuja", "NG", R.drawable.n),
        Country("République democratique du Congo", "Kinshasa", "CD", R.drawable.rd),
        Country("Rwanda", "Kigali", "RW", R.drawable.r),
        Country("Afrique du Sud", "Pretoria", "ZA", R.drawable.s),
        Country("Zambie", "Lusaka", "ZM", R.drawable.z),
    )

    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(countries) { country ->
            CountryItem(country = country)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCountryList() {
    DrapeauTheme {
        CountryListScreen()
    }
}
