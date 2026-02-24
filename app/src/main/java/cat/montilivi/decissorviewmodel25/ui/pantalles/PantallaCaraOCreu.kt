package cat.institutmontivi.decissorviewmodel25.ui.pantalles

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.institutmontivi.decissorviewmodel25.ui.common.Boto
import cat.montilivi.decissorviewmodel25.R
import cat.montilivi.decissorviewmodel25.ui.ViewModels.CaraOCreuEstat
import cat.montilivi.decissorviewmodel25.ui.ViewModels.CaraOCreuViewModel

//@Preview
@SuppressLint("UnrememberedMutableState")
@Composable
fun PantallaCaraOCreu (
    viewModel: CaraOCreuViewModel = viewModel()
) {
    val _estat by mutableStateOf(CaraOCreuEstat())
    Column(
        Modifier
            .padding(32.dp)
            .fillMaxSize())
    {
        var imatge = R.drawable.question
        if (_estat.resultat == 1) imatge = R.drawable.creupng
        else if (_estat.resultat == 2) imatge = R.drawable.carapng
        Image(
            painter = painterResource(id = imatge), contentDescription = null,
            modifier = Modifier
                .weight(5f)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally), contentScale = ContentScale.Fit
        )

        if (!_estat.sortejant) {
            Boto(
                modifier = Modifier
                    .weight(0.75F)
                    .fillMaxHeight(),
                text = "Sorteja",
                clic = {
                    viewModel.sorteja(500L)
                })
        } else {
            Text(
                text = "Sortejant...",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .align ( Alignment.CenterHorizontally )
            )
        }
    }
}
