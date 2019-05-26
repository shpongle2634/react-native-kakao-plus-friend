
# react-native-kakao-plus-friend


### Note

안녕하세요. 술 한 병으로 모두가 어깨춤을 추게하는 '꽁알' 서비스를 준비중인 JOOTOPIA입니다.
RN으로 서비스를 개발하는 중 카카오플러스 친구 기능이 필요하여 본 모듈을 제작하게 되었습니다.
지원하지 않는 기능 및 오류가 있으시면 이슈란에 남겨주시기 바랍니다.

## Getting started

`$ npm install react-native-kakao-plus-friend --save`

### 빠른 설치
react-native link 를 이용하시면 빠른 설치가 가능합니다.

`$ react-native link react-native-kakao-plus-friend`

### 수동 설치
위 react-native link 를 사용하시지 않는 분들은 본 모듈을 IOS, Android에 사용하기위해 아래와 같은 링크 절차를 거쳐야 합니다.

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-kakao-plus-friend` and add `RNKakaoPlusFriend.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNKakaoPlusFriend.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import co.jootopia.kakao.plus.RNKakaoPlusFriendPackage;` to the imports at the top of the file
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


## Install KakaoOpenSDK

#### IOS

카카오 PlusFriend를 사용하기위해서는 KakaoOpenSDK가 필요합니다.
아래 카카오 공식 가이드에서 OpenSDK를 다운 받으시기 바랍니다.
https://developers.kakao.com/docs/ios/getting-started#kakao-sdk-설치

**Note**: CocoaPod 사용중인 경우에도 다운 받으셔야합니다.
pod 'KakaoOpenSDK' 스펙에는 플러스친구를 사용하기위한 Framework가 없습니다.
때문에 SDK를 받으셔서 개발중인 Xcode 프로젝트에 KakaoPlusFriend.framework 를 Frameworks Group 에 drag & drop 해주시기 바랍니다.

SDK 설치가 완료되었다면, 카카오 플러스친구 공식가이드
https://developers.kakao.com/docs/ios/plusfriend 를 참고하셔 설정을 완료하시길 바랍니다.

#### Android

카카오 공식가이드

개발 환경 구성
https://developers.kakao.com/docs/android/getting-started

플러스 친구
https://developers.kakao.com/docs/android/plusfriend 를 참고하시기 바랍니다.

## Usage
```javascript
import RNKakaoPlusFriend from 'react-native-kakao-plus-friend';

  //...RN CODE

  // 친구 추가 하기로 링크
  addFriend = async () => {
    const response = await RNKakaoPlusFriend.addFriend('kakao plus friend code');
  }

  // 바로 채팅하기로 링크
  chat = async () => {
    const response = await RNKakaoPlusFriend.chat('kakao plus friend code');
  }

  //...RN CODE

```

**Note**: 참고로 안드로이드에서는 플러스 친구 링크를 연동하지 않는 편이 좋습니다.
이 API는 카카오톡이 설치되어있지 않은 환경에서는 카카오톡 앱 설치 링크로 유도됩니다.
따라서, 구글 플레이스토어 정책상 앱 설치 유도로 간주되어 앱 서비스가 정지되는 경우가 발생합니다. 위 사용에서 if(Platform.OS==='ios') 와 같은 조건문을 붙여 IOS 환경에서만 사용하시길 권장드립니다.
