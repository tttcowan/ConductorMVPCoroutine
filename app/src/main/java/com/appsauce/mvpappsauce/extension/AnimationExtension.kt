package com.appsauce.mvpappsauce.extension

import android.animation.Animator
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.support.annotation.ColorInt
import android.view.View
import android.view.animation.Animation
import com.appsauce.mvpappsauce.R

fun View.fadeIn(duration: Long = 0L, finish: () -> Unit = {}) {
    val animation = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.fade_in)
    if (duration != 0L) {
        animation.duration = duration
    }
    animation.onAnimationFinish(finish)
    startAnimation(animation)
    this.visibility = View.VISIBLE
}

fun View.fadeOut(duration: Long = 0L, finish: () -> Unit = {}) {
    val animation = android.view.animation.AnimationUtils.loadAnimation(context, R.anim.fade_out)
    if (duration != 0L) {
        animation.duration = duration
    }
    animation.onAnimationFinish {
        View.INVISIBLE
        finish()
    }
    startAnimation(animation)
    this.visibility = View.VISIBLE
}

fun View.animateBg(
    @ColorInt fromColor: Int, @ColorInt toColor: Int, durationMs: Long,
    finish: () -> Unit = {}
): ValueAnimator {
    val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), fromColor, toColor)
    colorAnimation.duration = durationMs
    colorAnimation.addUpdateListener { animator -> this.setBackgroundColor(animator.animatedValue as Int) }
    colorAnimation.addListener(object : Animator.AnimatorListener {
        override fun onAnimationRepeat(animation: Animator?) {
        }

        override fun onAnimationEnd(animation: Animator?) {
            finish()
        }

        override fun onAnimationCancel(animation: Animator?) {
        }

        override fun onAnimationStart(animation: Animator?) {
        }
    })
    colorAnimation.start()
    return colorAnimation
}

fun View.stopAnimation() {
    animation?.setAnimationListener(null)
    clearAnimation()
}

fun ValueAnimator.stopAnimation() {
    removeAllListeners()
    end()
    cancel()
}

fun Animation.onAnimationFinish(finish: () -> Unit) {
    setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationRepeat(animation: Animation?) {
        }

        override fun onAnimationEnd(animation: Animation?) {
            finish()
        }

        override fun onAnimationStart(animation: Animation?) {
        }
    })
}
