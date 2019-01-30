
#import "RNKakaoPlusFriend.h"

#import <KakaoPlusFriend/KakaoPlusFriend.h>



@implementation RNKakaoPlusFriend

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(addFriend : (NSString *) friendId
                  resolver: (RCTPromiseResolveBlock)resolve
                  rejecter: (RCTPromiseRejectBlock)reject)
{
    
    KPFPlusFriend *plusFriend = [[KPFPlusFriend alloc] initWithId:friendId];
    [plusFriend addFriend];
    NSDictionary * response=[NSDictionary dictionaryWithObjectsAndKeys:@"true",@"success",nil];
    resolve(response);
};


RCT_EXPORT_METHOD(chat : (NSString *) friendId
                  resolver: (RCTPromiseResolveBlock)resolve
                  rejecter: (RCTPromiseRejectBlock)reject)
{
    
    KPFPlusFriend *plusFriend = [[KPFPlusFriend alloc] initWithId:friendId];
    [plusFriend chat];
    NSDictionary * response=[NSDictionary dictionaryWithObjectsAndKeys:@"true",@"success",nil];
    resolve(response);
};

@end
  
