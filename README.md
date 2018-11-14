# Falert

<img src="https://raw.githubusercontent.com/Far5had70/Falert/master/clip.gif" height="480" width="270">

 Falert is a beautiful dialog for Android.



# Featuresnegative

type(single button , double button)

Background (button)

icon(drawable)

customView (View)

Button (size , color , text)

Radius (alert , button)

TypeFace(directory: Assets/sampleFont.ttf)




# Installation

Step 1. Add the JitPack repository to your build file


Add it in your root build.gradle at the end of repositories:

```gradle
	dependencies {
	        implementation 'com.github.Far5had70:Falert:1.1.0'
	}
```


Step 2. Add the dependency
```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```




## Demo

You can try it out here [Sample Application](https://github.com/Far5had70/Falert/blob/master/app/src/main/java/com/shaygan/customalert/MainActivity.java)




# Usage



**With Double Button Example:**

```java
                LayoutInflater inflaterr = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = inflaterr.inflate(R.layout.custom_view, null, false); // init custum view

                Falert falert = new Falert(this)
                        .setButtonType(FalertButtonType.Double_BUTTON) // FalertButtonType.Double_BUTTON OR FalertButtonType.ONE_BUTTON
                        .customView(customView) // set your custom view here
                        .setAutoDismiss(true) // button rule, when user click on this
                        .setPositiveText("بلی") // set positive text
                        .setNegativeText("خیر") // set negative text
                        .setPositiveButtonBackground(getResources().getColor(R.color.falert_green)) // button (positive) background color
                        .setNegativeButtonBackground(getResources().getColor(R.color.falert_red)) // button (negative) background color
                        .setButtonTextColor(getResources().getColor(R.color.falert_white)) // button (all) text color
                        .setHeaderIcon(getResources().getDrawable(R.drawable.luncher)) // header icon drawable
                        .setAlertRadius(40) // set radius for alert view
                        .setButtonRadius(80) // set radius for button
                        .setButtonTextSize(13) // button (all) text size
                        .setHeaderIconEnable(true) // visible Or invisible Icon Header
                        .setButtonEnable(true) // visible Or invisible Buttons
                        .setTypeFace(Typeface.createFromAsset(getAssets(), "bsans.ttf")) // set typeface
                        .setDoubleButtonListener(new DoubleButtonListener() {
                            @Override
                            public void onClickPositive() {
                                Toast.makeText(MainActivity.this, "Positive", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onClickNegative() {
                                Toast.makeText(MainActivity.this, "Negative", Toast.LENGTH_SHORT).show();
                            }
                        });
                falert.show(getSupportFragmentManager() , "");
```



**Date Picker:**

```java
        LayoutInflater inflaterr = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = inflaterr.inflate(R.layout.custom_view, null, false); // init custum view

                Falert falert = new Falert(this)
                        .setButtonType(FalertButtonType.ONE_BUTTON) // FalertButtonType.Double_BUTTON OR FalertButtonType.ONE_BUTTON
                        .customView(customView) // set your custom view here
                        .setAutoDismiss(true) // button rule, when user click on this
                        .setSingleButtonBackground(getResources().getColor(R.color.falert_green)) // button background color
                        .setButtonTextColor(getResources().getColor(R.color.falert_white)) // button text color
                        .setPositiveText("بلی") // set button text
                        .setHeaderIcon(getResources().getDrawable(R.drawable.luncher)) // header icon drawable
                        .setAlertRadius(40) // set radius for alert view
                        .setButtonRadius(80) // set radius for button
                        .setButtonTextSize(13) // button (all) text size
                        .setHeaderIconEnable(true) // visible Or invisible Icon Header
                        .setButtonEnable(true) // visible Or invisible Buttons
                        .setTypeFace(Typeface.createFromAsset(getAssets(), "bsans.ttf")) // set typeface
                        .setSingleButtonListener(new SingleButtonListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
                            }
                        });
                falert.show(getSupportFragmentManager() , "");
```




# Developed By

Farshad Asgharzadeh

For contact, shoot me an email at ferik800@gmail.com
