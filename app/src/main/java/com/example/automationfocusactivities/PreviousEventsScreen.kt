package com.example.automationfocusactivities.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Environment
import java.io.File

@Composable
fun PreviousEventsScreen(
    onBack: () -> Unit
) {

    var downloadMessage by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Button(
            onClick = onBack
        ) {
            Text("← Back")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "📂 Previous Events",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        PreviousEventCard(
            title = "Coding Competition 2025",
            date = "10 June 2025",
            status = "Winner"
        )

        Spacer(modifier = Modifier.height(12.dp))

        PreviousEventCard(
            title = "AI Workshop 2025",
            date = "15 July 2025",
            status = "Certificate Available"
        )

        Spacer(modifier = Modifier.height(12.dp))

        PreviousEventCard(
            title = "Technical Seminar 2025",
            date = "20 August 2025",
            status = "Participation Completed"
        )

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = {
                val success = createCertificatePdf(context)

                downloadMessage = if (success) {
                    "✅ Certificate PDF created successfully!"
                } else {
                    "❌ Unable to create certificate PDF."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Download Certificates")
        }

        Spacer(modifier = Modifier.height(15.dp))

        if (downloadMessage.isNotEmpty()) {
            Text(
                text = downloadMessage,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun PreviousEventCard(
    title: String,
    date: String,
    status: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text("📅 Date : $date")

            Spacer(modifier = Modifier.height(4.dp))

            Text("🏆 Status : $status")
        }
    }
}

fun createCertificatePdf(context: android.content.Context): Boolean {

    return try {
        val pdfDocument = PdfDocument()

        val pageInfo = PdfDocument.PageInfo.Builder(
            595,
            842,
            1
        ).create()

        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas

        val titlePaint = Paint().apply {
            textSize = 28f
            isFakeBoldText = true
            textAlign = Paint.Align.CENTER
        }

        val textPaint = Paint().apply {
            textSize = 18f
            textAlign = Paint.Align.CENTER
        }

        canvas.drawText(
            "CERTIFICATE",
            297f,
            180f,
            titlePaint
        )

        canvas.drawText(
            "Automation of Focus Activities",
            297f,
            240f,
            textPaint
        )

        canvas.drawText(
            "Certificate of Participation",
            297f,
            300f,
            textPaint
        )

        canvas.drawText(
            "Previous Events 2025",
            297f,
            360f,
            textPaint
        )

        pdfDocument.finishPage(page)

        val downloadsFolder =
            context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)

        val file = File(
            downloadsFolder,
            "Event_Certificate.pdf"
        )

        pdfDocument.writeTo(file.outputStream())
        pdfDocument.close()

        true

    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}