package com.pgone.employee.component

import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.pgone.employee.R
import kotlin.reflect.KFunction1

class AccountInputField(context: Context, val attrs: AttributeSet) : LinearLayout(context, attrs),
  TextWatcher {

  private val RIGHT_ICON_NONE = 0
  private val RIGHT_ICON_TOGGLE = 1
  private val RIGHT_ICON_CLICK = 2

  private val Resource = context.resources

  // Default Strings
  private val DefHint = Resource.getString(R.string.defaultHint)
  private val DefInputType = InputType.TYPE_CLASS_TEXT

  private var textField: String = ""
  private var hintField: String = ""
  private var errorText: String? = null
  private var inputTypeField: Int = 0

  private var visibleRightIcon: Boolean = false
  private var rightIcon: Drawable? = null
  private var rightIconToggleOn: Drawable? = null
  private var rightIconToggleOff: Drawable? = null
  private var rightIconType: Int = 0

  private var editText: EditText? = null
  private var errorMessageTextView: TextView? = null
  private var rightIconView: ImageView? = null
  private var editTextWrap: ConstraintLayout? = null

  private var toggle: Boolean = false

  private var event: Event? = null

  init {
    getAttributes()
    initView()
  }

  private fun getAttributes() {
    val _attrs = context.obtainStyledAttributes(attrs, R.styleable.AccountInputField, 0, 0)
    textField = _attrs.getString(R.styleable.AccountInputField_textField) ?: ""
    hintField = _attrs.getString(R.styleable.AccountInputField_hintField) ?: DefHint
    errorText = _attrs.getString(R.styleable.AccountInputField_errorText)
    inputTypeField =
      _attrs.getInt(R.styleable.AccountInputField_inputTypeField, DefInputType)
    visibleRightIcon =
      _attrs.getBoolean(R.styleable.AccountInputField_visibleRightIcon, false)

    if (visibleRightIcon) {
      rightIconType = _attrs.getInt(R.styleable.AccountInputField_rightIconType, RIGHT_ICON_NONE)

      // When `rightIconToggle` is true then get `rightIconToggleOn` and `rightIconToggleOff`
      // Else just get `rightIcon`

      if (rightIconType == RIGHT_ICON_TOGGLE) {
        rightIconToggleOn = _attrs.getDrawable(R.styleable.AccountInputField_rightIconToggleOn)
        rightIconToggleOff = _attrs.getDrawable(R.styleable.AccountInputField_rightIconToggleOff)
      } else rightIcon = _attrs.getDrawable(R.styleable.AccountInputField_rightIcon)
    }
    _attrs.recycle()
  }

  private fun initView() {
    inflate(context, R.layout.account_input_field, this)

    editText = findViewById(R.id.editText)
    errorMessageTextView = findViewById(R.id.errorMessageTextView)
    rightIconView = findViewById(R.id.rightIconView)
    editTextWrap = findViewById(R.id.editTextWrap)

    editTextWrap?.setOnFocusChangeListener(null)
    initRightIconView()
    initEditText()
  }

  private fun initRightIconView() {
    if (visibleRightIcon) {
      rightIconView?.apply {
        visibility = View.VISIBLE

        // Define the setOnClickListener
        setOnClickListener {
          val selectionEnd = editText?.selectionEnd
          if (rightIconType == RIGHT_ICON_TOGGLE) {
            toggle = !toggle

            // `toggle` is true then set `rightIconToggleOn` for `rightIconView`
            // Else set `rightIconToggleOff` for it.
            if (toggle)
              rightIconView?.setImageDrawable(rightIconToggleOn)
            else
              rightIconView?.setImageDrawable(rightIconToggleOff)
            event?.onToggleRightIcon(toggle)
          } else if (rightIconType == RIGHT_ICON_CLICK) {
            //event?.onRightIconClick()
          }
          editText?.setSelection(selectionEnd ?: (textField.length - 1))
        }
      }
    } else {
      rightIconView?.visibility = View.GONE
    }
  }

  private fun initEditText() {
    editText?.apply {
      hint = hintField
      inputType = inputTypeField
      setText(textField)
      addTextChangedListener(this@AccountInputField)
      setOnFocusChangeListener(object : OnFocusChangeListener {
        override fun onFocusChange(v: View?, hasFocus: Boolean) {
          if (hasFocus) {
            editTextWrap?.background = Resource.getDrawable(R.drawable.drawable_acc_input_focus)
            return
          }
          if (!errorText.isNullOrEmpty()) {
            editTextWrap?.background = Resource.getDrawable(R.drawable.drawable_acc_input_error)
            return
          }
          editTextWrap?.background = Resource.getDrawable(R.drawable.drawable_acc_input)
        }
      })
    }
  }

  override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

  override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    if (before != count) {
      editTextWrap?.background = Resource.getDrawable(R.drawable.drawable_acc_input_focus)
      errorMessageTextView?.visibility = View.GONE
      errorText = null
      textField = editText?.text.toString()
    }
  }

  override fun afterTextChanged(s: Editable?) {}

  fun setErrorText(error: String?) {
    if (!error.isNullOrEmpty()) {
      errorText = error
      editTextWrap?.background = Resource.getDrawable(R.drawable.drawable_acc_input_error)
      errorMessageTextView?.visibility = View.VISIBLE
      errorMessageTextView?.text = errorText
    }
  }

  fun setTextField(text: String?) {
    textField = text ?: ""
    editText?.setText(textField)
  }

  fun getTextField(): String = textField

  fun setAccountInputFieldEvent(event: Event) {
    this.event = event
  }

  fun setInputType(inputType: Int) {
    inputTypeField = inputType
    editText?.inputType = inputTypeField
  }

  fun clearFocusField() {
    editText?.clearFocus()
  }

  interface Event {
    fun onToggleRightIcon(toggle: Boolean)
  }
}