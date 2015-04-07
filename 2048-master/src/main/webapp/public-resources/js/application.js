// Wait till the browser is ready to render the game (avoids glitches)
window.requestAnimationFrame(function() {
  new GameManager(4, KeyboardInputManager, HTMLActuator, LocalStorageManager, uploadScore);
});

function uploadScore(score) {
  $.ajax({
    type : "post",
    url : "/score/upload",
    data : {
      score : score
    },
    success : function(data) {
      if (data) {
        if (data.success) {
          console.info("upload success");
        } else {
          console.warn("upload failure with code = " + data.errorMessage);
        }
      } else {
        console.error("fail to call upload");
      }
    },
    dataType : "json"
  });
};

function getHighestScore(callback) {
  $.ajax({
    type : "get",
    url : "/score/getHighest",
    async : false,
    success : function(data) {
      if (data) {
        if (data.success) {
          console.info("get highest score success");
          callback(data.result.score);
        } else {
          console.warn("get highest score failure with code = " + data.errorMessage);
        }
      } else {
        console.error("fail to call getHighest");
      }
    },
    dataType : "json"
  });
};