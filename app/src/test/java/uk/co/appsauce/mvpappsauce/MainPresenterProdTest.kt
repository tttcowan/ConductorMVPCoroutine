package uk.co.appsauce.mvpappsauce

import com.appsauce.mvpappsauce.main.MainPresenterProd
import com.appsauce.mvpappsauce.main.MainView
import com.appsauce.mvpappsauce.navigation.NavigationService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.only
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainPresenterProdTest {

    private val navigationService: NavigationService = mock()
    private val view: MainView = mock()
    private val presenter: MainPresenterProd = MainPresenterProd(view, navigationService)

    @Test
    fun testNavigateToHomeOnViewReady() {
        presenter.viewReady()
        verify(navigationService, times(1)).toHome()
    }

    @Test
    fun testNavigateToHomeIsOnlyCallOnViewReady() {
        presenter.viewReady()
        verify(navigationService, only()).toHome()
    }
}