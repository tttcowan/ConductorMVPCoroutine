package uk.co.appsauce.mvpappsauce

import com.appsauce.mvpappsauce.main.MainPresenterProd
import com.appsauce.mvpappsauce.main.MainView
import com.appsauce.mvpappsauce.navigation.NavigationService
import com.nhaarman.mockitokotlin2.only
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainPresenterProdTest {

    @Mock
    private lateinit var navigationService: NavigationService
    @Mock
    private lateinit var view: MainView
    private lateinit var presenter: MainPresenterProd

    @Before
    fun before() {
        presenter = MainPresenterProd(view, navigationService)
    }

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