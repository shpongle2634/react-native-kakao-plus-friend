
# react-native-kakao-plus-friend

## Getting started

`$ npm install react-native-kakao-plus-friend --save`

### Mostly automatic installation

`$ react-native link react-native-kakao-plus-friend`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-kakao-plus-friend` and add `RNKakaoPlusFriend.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNKakaoPlusFriend.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNKakaoPlusFriendPackage;` to the imports at the top of the file
  - Add `new RNKakaoPlusFriendPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-kakao-plus-friend'
  	project(':react-native-kakao-plus-friend').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-kakao-plus-friend/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-kakao-plus-friend')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNKakaoPlusFriend.sln` in `node_modules/react-native-kakao-plus-friend/windows/RNKakaoPlusFriend.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Kakao.Plus.Friend.RNKakaoPlusFriend;` to the usings at the top of the file
  - Add `new RNKakaoPlusFriendPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNKakaoPlusFriend from 'react-native-kakao-plus-friend';

// TODO: What to do with the module?
RNKakaoPlusFriend;
```
  