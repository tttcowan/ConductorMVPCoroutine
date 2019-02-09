package uk.co.appsauce.mvpappsauce

import com.appsauce.mvpappsauce.dialog.DialogId.DEFAULT
import com.appsauce.mvpappsauce.dialog.DialogService
import com.appsauce.mvpappsauce.home.HomePresenterProd
import com.appsauce.mvpappsauce.home.HomeView
import com.appsauce.mvpappsauce.module.CoroutineSchedulerModule
import com.appsauce.mvpappsauce.navigation.NavigationService
import com.appsauce.mvpappsauce.remote.RemoteService
import com.appsauce.mvpappsauce.remote.model.TestResponse
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.argThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomePresenterProdTest {

    private val dialogService: DialogService = mock()
    private val navigationService: NavigationService = mock()
    private val remoteService: RemoteService = mock()
    private val view: HomeView = mock()
    private lateinit var presenter: HomePresenterProd

    @Before
    fun before() {
        CoroutineSchedulerModule.testing()
        presenter = HomePresenterProd(remoteService, navigationService, dialogService)
    }

    @Test
    fun testInitCoroutineCalled() {
        runBlocking {
            whenever(remoteService.initCoroutine()).thenReturn(TestResponse())
            presenter.attachView(view)
            verify(remoteService, times(1)).initCoroutine()
        }
    }

    @Test
    fun testInitCoroutineCallsError() {
        presenter.attachView(view)
        verify(view, times(1)).callError()
    }

    @Test
    fun testInitCoroutineCallsComplete() {
        runBlocking {
            whenever(remoteService.initCoroutine()).thenReturn(TestResponse())
            presenter.attachView(view)
            verify(view, times(1)).callComplete()
        }
    }

    @Test
    fun testDialogShowOnCallReturn() {
        presenter.callReturn()
        verify(dialogService, times(1)).showTwoButtonDialog(any(), any(), any(), any())
    }

    @Test
    fun testDialogIdIsDefault() {
        presenter.callReturn()
        verify(dialogService, times(1)).showTwoButtonDialog(any(), any(), any(), argThat { this == DEFAULT })
    }

    @Test
    fun testDialogReturnCalledOnDismiss() {
        presenter.attachView(view)
        presenter.dialogDismiss(DEFAULT)
        verify(view, times(1)).dialogReturn()
    }

    @Test
    fun testDialogReturnCalledOnPrimary() {
        presenter.attachView(view)
        presenter.dialogPrimary(DEFAULT)
        verify(view, times(1)).dialogReturn()
    }

    @Test
    fun testDialogReturnCalledOnSecondary() {
        presenter.attachView(view)
        presenter.dialogSecondary(DEFAULT)
        verify(view, times(1)).dialogReturn()
    }
}