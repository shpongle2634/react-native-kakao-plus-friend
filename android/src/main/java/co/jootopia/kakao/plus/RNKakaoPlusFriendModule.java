
package co.jootopia.kakao.plus;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.kakao.plusfriend.PlusFriendService;
import com.kakao.util.exception.KakaoException;

public class RNKakaoPlusFriendModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNKakaoPlusFriendModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNKakaoPlusFriend";
  }

  @ReactMethod
  public void addFriend(final String plusFriendId, final Promise promise) {
    try {
      PlusFriendService.getInstance().addFriend(this.getCurrentActivity(), plusFriendId);
      WritableMap response = Arguments.createMap();
      response.putString("success","true");
      promise.resolve(response);
    } catch (KakaoException e) {
      // 에러 처리 (앱키 미설정 등등)
      promise.reject(e.getCause());
    }
  }

  @ReactMethod
  public void chat(final String plusFriendId, final Promise promise){
    try {
      PlusFriendService.getInstance().chat(this.getCurrentActivity(), plusFriendId);
      WritableMap response = Arguments.createMap();
      response.putString("success","true");
      promise.resolve(response);

    } catch (KakaoException e) {
      // 에러 처리 (앱키 미설정 등등)
      promise.reject(e.getCause());
    }
  }
}