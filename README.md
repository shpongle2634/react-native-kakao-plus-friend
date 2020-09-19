
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

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
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
https://developers.kakao.com/docs/ios/plusfriend 를 참고하셔 설정을 ㅇ완료하시길 바랍니다.

#### Android

카카오 공식가이드

개발 환경 구성
https://developers.kakao.com/docs/android/getting-started

플러스 친구
https://developers.kakao.com/docs/android/plusfriend 를 참고하시기 바랍니다.

**Note** : 위 '카카오 공식 가이드-개발 환경 구성에
/android/app/build.gradle 를 설정해주시는 부분이 있는데,
플러스친구 설정은 나와있지 않습니다. 찾아본 결과 dependencies에
아래와 같이 추가해주셔야 합니다.

```
/android/app/build.gradle

dependencies {
    ...

    // 카카오 플러스친구 sdk를 사용하기 위해 필요.
    compile group: 'com.kakao.sdk', name: 'plusfriend', version: project.KAKAO_SDK_VERSION

}

```

## Usage
```javascript
import RNKakaoPlusFriend from 'react-native-kakao-plus-friend';

  //...RN CODE

   //친구 추가 하기로 링크
  addFriend= async ()=>{
      await RNKakaoPlusFriend.addFriend('kakao plus friend code');
  }
  //바로 채팅하기로 링크
  chat= async ()=>{
      await RNKakaoPlusFriend.chat('kakao plus friend code');
  }

  //...RN CODE

```

**Note**: 참고로 안드로이드에서는 플러스 친구 링크를 연동하지 않는 편이 좋습니다.
이 API는 카카오톡이 설치되어있지 않은 환경에서는 카카오톡 앱 설치 링크로 유도됩니다.
따라서, 구글 플레이스토어 정책상 앱 설치 유도로 간주되어 앱 서비스가 정지되는 경우가 발생합니다. 위 사용에서 if(Platform.OS==='ios') 와 같은 조건문을 붙여 IOS 환경에서만 사용하시길 권장드립니다.

### by kyungjoon.go (ios 연동시 하단의 애러부분 수정)
[!] The `RNKakaoPlusFriend` pod failed to validate due to 1 error:

    - ERROR | attributes: Missing required attribute `homepage`.

    - WARN  | source: The version should be included in the Git tag.

    - WARN  | description: The description is equal to the summary.
    
### ios legacy sdk link

- https://developers.kakao.com/docs/latest/ko/sdk-download/ios-v1

### ios 에서 chat method 실행시 애러남..(해결방법 알려주3)

- backend.js:32 Possible Unhandled Promise Rejection (id: 0):
- TypeError: Cannot read property 'chat' of undefined
- TypeError: Cannot read property 'chat' of undefined
    at _callee$ (http://192.168.0.38:8081/index.bundle?platform=ios&dev=true&minify=false:191821:91)
    at tryCatch (http://192.168.0.38:8081/index.bundle?platform=ios&dev=true&minify=false:1430:19)
    at Generator.invoke [as _invoke] (http://192.168.0.38:8081/index.bundle?platform=ios&dev=true&minify=false:1603:24)
    at Generator.next (http://192.168.0.38:8081/index.bundle?platform=ios&dev=true&minify=false:1473:23)
    at tryCatch (http://192.168.0.38:8081/index.bundle?platform=ios&dev=true&minify=false:1430:19)
    at invoke (http://192.168.0.38:8081/index.bundle?platform=ios&dev=true&minify=false:1503:22)
    at http://192.168.0.38:8081/index.bundle?platform=ios&dev=true&minify=false:1533:13
    at tryCallTwo (http://192.168.0.38:8081/index.bundle?platform=ios&dev=true&minify=false:27359:7)
    at doResolve (http://192.168.0.38:8081/index.bundle?platform=ios&dev=true&minify=false:27523:15)
    at new Promise (http://192.168.0.38:8081/index.bundle?platform=ios&dev=true&minify=false:27382:5)
   
### android
 /android/gradle.properties

 KAKAO_SDK_GROUP=com.kakao.sdk
 KAKAO_SDK_VERSION=1.30.2

속성값 추가..필요


