package cat.institutmontivi.decissorviewmodel25.ui.pantalles

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.institutmontivi.decissorviewmodel25.ui.common.Boto
import cat.montilivi.decissorviewmodel25.ui.ViewModels.TriaNumeroViewModel

@Preview
@Composable
fun PantallaTriaUnNumero (
    viewModel: TriaNumeroViewModel = viewModel()
) {
    val estat = viewModel.estat


    Column(
        Modifier
            .padding(32.dp)
            .fillMaxSize())
    {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Text(
                if (estat.sortejant) {
                    "???"
                } else {
                    estat.resultat.toString()
                },
                Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.displayLarge,
                fontSize = 148.sp,
                textAlign = TextAlign.Center
            )
        }

        if (!estat.sortejant) {
            Boto(
                modifier = Modifier
                    .weight(0.75F)
                    .fillMaxHeight(),
                text = "Sorteja",
                clic = {
                    viewModel.sortejaNumero(
                        0,
                        999,
                        500L
                    )
                }
            )
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