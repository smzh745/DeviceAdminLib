# DeviceAdminLib
<p> Step 1. Add the JitPack repository to your build file <br/><br>
Add it in your root build.gradle at the end of repositories:</p>
<pre><code>allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
</code></pre>

<p>
Step 2. Add the dependency
</p>
<pre><code>
dependencies {
   	implementation 'com.github.smzh745:DeviceAdminLib:1.0.1'
	}
</code></pre>

# How does it works
<b> context => your application context </b>

<p>For activating device admin use the below code: </p>
<pre><code>
        DeviceAdminCall.getInstance(context).activateAdmin();
</code></pre>


<p>For deactivating device admin use the below code: </p>
<pre><code>
        DeviceAdminCall.getInstance(context).deactivateAdmin();
</code></pre>

<p>To lock the screen use the below code: </p>
<pre><code>
        DeviceAdminCall.getInstance(context).deviceLock();
</code></pre>

<p>To erase the data use the below code: </p>
<pre><code>
        DeviceAdminCall.getInstance(context).eraseData();
</code></pre>

