package com.plcoding.echojournal.echos.di

import com.plcoding.echojournal.echos.data.audio.AndroidAudioPlayer
import com.plcoding.echojournal.echos.data.recording.AndroidVoiceRecorder
import com.plcoding.echojournal.echos.domain.recording.RecordingStorage
import com.plcoding.echojournal.echos.domain.recording.VoiceRecorder
import com.plcoding.echojournal.echos.data.recording.InternalRecordingStorage
import com.plcoding.echojournal.echos.domain.audio.AudioPlayer
import com.plcoding.echojournal.echos.domain.echo.EchoDataSource
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import com.plcoding.echojournal.echos.presentation.echos.EchosViewModel
import com.plcoding.echojournal.echos.presentation.create_echo.CreateEchoViewModel
import com.plcoding.echojournal.echos.presentation.settings.SettingsViewModel
import com.plcoding.echojournal.echos.data.echo.RoomEchoDataSource
import com.plcoding.echojournal.echos.domain.settings.SettingsPreferences
import com.plcoding.echojournal.echos.data.settings.DataStoreSettings
import org.koin.core.module.dsl.singleOf

val echoModule = module {
    singleOf(::AndroidVoiceRecorder) bind VoiceRecorder::class
    singleOf(::InternalRecordingStorage) bind RecordingStorage::class
    singleOf(::AndroidAudioPlayer) bind AudioPlayer::class
    singleOf(::RoomEchoDataSource) bind EchoDataSource::class
    singleOf(::DataStoreSettings) bind SettingsPreferences::class

    viewModelOf(::EchosViewModel)
    viewModelOf(::CreateEchoViewModel)
    viewModelOf(::SettingsViewModel)
}